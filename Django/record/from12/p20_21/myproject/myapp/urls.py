from django.urls import path
from . import views
#from .views import StudentListView

urlpatterns = [
    #path('students/', StudentListView.as_view(), name='students'),
    path("students/<int:id>/", views.student_detail, name="student_detail"),
    path("students/", views.student_list, name="student_list"),                 # READ
    path("students/create/", views.student_create, name="student_create"),      # CREATE
    path("students/edit/<int:id>/", views.student_update, name="student_update"), # UPDATE
    path("students/delete/<int:id>/", views.student_delete, name="student_delete"), # DELETE
]