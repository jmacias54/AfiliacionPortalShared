import router from '../router';
import requestSrv from './index';

function login(data) {
  return new Promise((resolve, reject) => {
    requestSrv({
      path: 'middle/login',
      method: 'POST',
      data,
    })
      .then(res => resolve(res))
      .catch(error => reject(error));
  });
}

function logout() {
  console.log('-- logout -- ')

  if (sessionStorage.getItem('token') !== null) {
    sessionStorage.removeItem('token');
    sessionStorage.removeItem('user');
    router.push('login');
  }
}

function refreshToken(data) {
  return new Promise((resolve, reject) => {
    requestSrv({
      path: 'middle/login',
      method: 'POST',
      data,
    })
      .then(res => resolve(res))
      .catch(error => reject(error));
  });
}

function getUserTimeSession() {
  return new Promise((resolve, reject) => {
    requestSrv({
      path: 'tiempo-restante',
      headers: {
        token: sessionStorage.getItem('token'),
      },
    })
      .then(({ data: { entity } }) => { resolve(entity); })
      .catch(error => reject(error));
  });
}

function updateToken() {
  return new Promise((resolve, reject) => {
    requestSrv({
      path: 'renovar-token',
      headers: {
        token: sessionStorage.getItem('token'),
      },
    })
      .then((res) => { resolve(res); })
      .catch(error => reject(error));
  });
}

export default {
  login,
  logout,
  refreshToken,
  getUserTimeSession,
  updateToken,
};
