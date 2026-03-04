from django.urls import path
from . import views

urlpatterns = [
    path('', views.home, name='home'),
    path('set-name/', views.set_name, name='set_name'),
    path('set-theme/', views.set_theme, name='set_theme'),
    path('clear-session/', views.clear_session, name='clear_session'),
    path('login/', views.user_login, name='login'),
    path('logout/', views.user_logout, name='logout'),
]
