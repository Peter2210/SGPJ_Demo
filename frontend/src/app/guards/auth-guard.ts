import { CanActivateFn, Router } from '@angular/router';
import { inject } from '@angular/core';

export const authGuard: CanActivateFn = (route, state) => {
  const router = inject(Router);
  const userType = localStorage.getItem('userType');

  // Se o usuário não estiver logado, manda para /Login
  if (!userType) {
    router.navigate(['/Login'], { replaceUrl: true });
    return false;
  }

  // Se estiver logado, permite acesso
  return true;
};