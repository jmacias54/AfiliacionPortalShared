package mx.profuturo.ap.middle.service.helper;

import java.io.IOException;
import java.util.List;

import mx.profuturo.ap.middle.modelo.ErrorException;
import mx.profuturo.ap.middle.service.exception.ReadValueException;
import mx.profuturo.ap.middle.service.exception.RestClientException;
import mx.profuturo.ap.middle.service.exception.UnknownResourceException;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

@Component
public class RestTemplateHelper {
private static final Logger LOGGER = Logger.getLogger(RestTemplateHelper.class);

	private RestTemplate restTemplate;
	private HttpHeaders headers = new HttpHeaders();
    private ObjectMapper objectMapper;

	public RestTemplateHelper() {
		LOGGER.debug(" --- Constructor Initializer  --- ");

		this.restTemplate = new RestTemplate();
		ClientHttpRequestFactory factory = this.restTemplate.getRequestFactory();

		if (factory instanceof SimpleClientHttpRequestFactory) {
			((SimpleClientHttpRequestFactory) factory).setConnectTimeout(50 * 1000);
			((SimpleClientHttpRequestFactory) factory).setReadTimeout(50 * 1000);
		} else if (factory instanceof HttpComponentsClientHttpRequestFactory) {
			((HttpComponentsClientHttpRequestFactory) factory).setReadTimeout(50 * 1000);
			((HttpComponentsClientHttpRequestFactory) factory).setConnectTimeout(50 * 1000);

		}
		this.restTemplate.setRequestFactory(factory);
		this.headers.setContentType(MediaType.APPLICATION_JSON);
		this.objectMapper = new ObjectMapper();
	}

    public <T> T getForEntity(Class<T> clazz, String url, Object... uriVariables) {
    	LOGGER.debug(" --- getForEntity  --- ");
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, uriVariables);
            JavaType javaType = objectMapper.getTypeFactory().constructType(clazz);
            return readValue(response, javaType);
        } catch (HttpClientErrorException exception) {
			if (exception.getStatusCode() == HttpStatus.NOT_FOUND) {
				LOGGER.error("No data found {} , getForList : " + url);
				throw new UnknownResourceException("No se encontraron datos :" + url);

			} else {
				LOGGER.error("rest client exception getForEntity  " + exception.getMessage());

				throw new RestClientException( exception.getMessage());
			}
		} catch (RestClientResponseException rre) {
			LOGGER.error(
					"RestClientResponseException  getForEntity : " + rre.getResponseBodyAsString());
			LOGGER.error("RestClientResponseException  getForEntity : ", rre);
			throw new RestClientException(rre.getResponseBodyAsString());
		}
    }

	public <T> List<T> getForList(Class<T> clazz, String url, Object... uriVariables) {
		LOGGER.debug(" --- getForList  --- ");
		try {
			ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, uriVariables);
			CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, clazz);
			return readValue(response, collectionType);
		} catch (HttpClientErrorException exception) {
			if (exception.getStatusCode() == HttpStatus.NOT_FOUND) {
				LOGGER.error("No data found {} , getForList :" + url);
				throw new UnknownResourceException("No se encontraron datos :" + url);

			} else {
				LOGGER.error("rest client exception getForList :" + exception.getMessage());

				throw new RestClientException( exception.getMessage());
			}
		} catch (RestClientResponseException rre) {
			LOGGER.error(
					"RestClientResponseException  getForList :" + rre.getResponseBodyAsString());
			LOGGER.error("RestClientResponseException  getForList :", rre);
			throw new RestClientException(rre.getResponseBodyAsString());
		}
	}

    public <T, R> T postForEntity(Class<T> clazz, String url, R body, Object... uriVariables) {
    	LOGGER.debug(" --- postForEntity  --- ");
    	try {
        HttpEntity<R> request = new HttpEntity<>(body);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class, uriVariables);
        JavaType javaType = objectMapper.getTypeFactory().constructType(clazz);
        return readValue(response, javaType);
    	} catch (HttpClientErrorException exception) {
			if (exception.getStatusCode() == HttpStatus.NOT_FOUND) {
				LOGGER.error("No data found {} , getForList  " + url);
				throw new UnknownResourceException("No se encontraron datos :" + url);

			} else {
				LOGGER.error("rest client exception postForEntity : " + exception.getMessage());

				throw new RestClientException(exception.getMessage());
			}
		} catch (RestClientResponseException rre) {
			LOGGER.error("RestClientResponseException : " + rre.getResponseBodyAsString());
			LOGGER.error("RestClientResponseException  : ", rre);
			throw new RestClientException(rre.getResponseBodyAsString());
		}catch (Throwable exceptionThrowable) {
		    LOGGER.error(" Throwable Error: " + exceptionThrowable.getMessage());
            LOGGER.error(" Throwable Error :", exceptionThrowable);
		}
        return null;
    }

	public <T, R> T putForEntity(Class<T> clazz, String url, R body, Object... uriVariables) {
		LOGGER.debug(" --- putForEntity --- ");
		try {
			HttpEntity<R> request = new HttpEntity<>(body);
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, request, String.class,
					uriVariables);
			JavaType javaType = objectMapper.getTypeFactory().constructType(clazz);
			return readValue(response, javaType);

		} catch (HttpClientErrorException exception) {
			if (exception.getStatusCode() == HttpStatus.NOT_FOUND) {
				LOGGER.error("No data found {} , putForEntity : " + url);
				throw new UnknownResourceException("No se encontraron datos :" + url);

			} else {
				LOGGER.error("rest client exception putForEntity : " + exception.getMessage());

				throw new RestClientException(exception.getMessage());
			}
		} catch (RestClientResponseException rre) {
			LOGGER.error(
					" " + rre.getResponseBodyAsString());
			LOGGER.error("RestClientResponseException  putForEntity: ", rre);
			throw new RestClientException(rre.getResponseBodyAsString());
		}
	}

    public void delete(String url, Object... uriVariables) {
    	LOGGER.debug(" --- delete  --- ");
        try {
            restTemplate.delete(url, uriVariables);
        } catch (RestClientException exception) {
            LOGGER.error(exception.getMessage());
            throw new RestClientException(exception.getMessage());

        }
        
    }

	public <T> T readValue(ResponseEntity<String> response, JavaType javaType) {
		LOGGER.debug(" --- readValue --- ");
		T result = null;
		if (response.getStatusCode() == HttpStatus.OK
				|| response.getStatusCode() == HttpStatus.CREATED) {
			try {
				result = objectMapper.readValue(response.getBody(), javaType);
			} catch (IOException e) {
				LOGGER.error(e.getMessage());				
				try {
					javaType = objectMapper.getTypeFactory().constructType(ErrorException.class);
					
					result = objectMapper.readValue(response.getBody(),javaType);
					
					ErrorException exception = (ErrorException) result; 
					
					if(exception.getExcepcion() != null && !exception.getExcepcion().equals("")){
						throw new ReadValueException(exception.getExcepcion()); 
					}else if(exception.getException() != null && !exception.getException().equals("")){
						throw new ReadValueException(exception.getException()); 
					}
					
				} catch (Exception ex) {
					LOGGER.error(ex.getMessage());
					throw new ReadValueException(ex.getMessage()); 
				}catch (Throwable throwable) {
					throw new RestClientException(throwable.getMessage());
				}
			}
		} else {
			LOGGER.error("No data found {}" + response.getStatusCode());
			throw new UnknownResourceException("No se encontro informacion :" + response.getStatusCode());
		}
		return result;
	}
}
