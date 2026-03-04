from django.urls import path
from . import views

urlpatterns = [
    path('student/add/', views.student_add, name='student_add'),
]
