from django.urls import path
from . import views

urlpatterns = [
    path('', views.home, name='home'),
    path('add/', views.addstudent, name='addstudent'),
    path('edit/<int:pk>/', views.editstudent, name='editstudent'),
    path('delete/<int:pk>/', views.deletestudent, name='deletestudent'),

]