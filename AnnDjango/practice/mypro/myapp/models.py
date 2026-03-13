from django.db import models
from django.contrib.auth.models import AbstractUser

# Create your models here.
class CustomUser(AbstractUser):
    Role_choice=[
        ('admin','Admin'),
        ('student','Student'),
        ('faculty','Faculty'),
    ]
    role=models.CharField(max_length=100,choices=Role_choice)

class Student(models.Model):
    name=models.CharField(max_length=100)
    age=models.IntegerField()
    course=models.CharField(max_length=100)
    email=models.EmailField()

    def __str__(self):
        return self.name