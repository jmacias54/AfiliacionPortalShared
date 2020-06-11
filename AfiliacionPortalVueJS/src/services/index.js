import axios from 'axios'
//axios.defaults.baseURL = 'http://localhost:9080/AfiliacionPortal/'
axios.defaults.baseURL = "http://172.22.180.163:8010/AfiliacionPortal/";

export default function executeRequest({
  path,
  data = {},
  method = 'GET',
  mocky = false,
  responseType,
  headers,
  params,
}) {
  function setQueryString(queryStringObj, methodReq) {
    if (methodReq === 'GET') {
      let queryString = ''
      const firstKeyProp = Object.keys(queryStringObj)[0]
      Object.keys(queryStringObj).forEach(prop => {
        queryString += `${prop === firstKeyProp ? '?' : '&'}${prop}=${
          queryStringObj[prop]
          }`
      })
      return queryString
    }
    return ''
  }
  const url = `${path}${setQueryString(data, method)}`
  if (mocky) {
    // axios.defaults.baseURL = `http://localhost:8080/bolsatrabajoprivado/`;
    console.log(mocky)
  }

  const token = sessionStorage.getItem('token')

  if (token != null && token !== '') {
    headers = {
      Authorization: 'Bearer ' + token,
    }
  }

  return axios({
    method,
    url,
    data,
    responseType,
    headers,
    params,
  })
    .then(res => Promise.resolve(res))
    .catch(error => Promise.reject(error))
}
