from django.urls import path
from . import views

urlpatterns = [
    path('', views.home, name='home'),
    path('deletestudent/', views.deletestudent, name='deletestudent'),
]
