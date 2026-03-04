from django.urls import path
from . import views

urlpatterns = [
    path('', views.feedback_form, name='feedback_form'),
    path('list/', views.feedback_list, name='feedback_list'),
]
