import { HttpInterceptorFn } from '@angular/common/http';

export const customInterceptor: HttpInterceptorFn = (req, next) => {
  // debugger;

  const myToken = sessionStorage.getItem('auth-token');

  if (myToken != null) {
    const cloneRequest = req.clone({
      setHeaders: {
        Authorization: `Bearer ${myToken}`,
      },
    });
    return next(cloneRequest);
  }
  return next(req);
};
