from django.db import models
from django.contrib.auth.models import AbstractUser

from django.db import models

class Course(models.Model):
    title = models.CharField(max_length=100)
    description = models.TextField()

    def __str__(self):
        return self.title
    
class Student(models.Model):
    name = models.CharField(max_length=100)
    age = models.IntegerField()
    course= models.ForeignKey(Course, on_delete=models.CASCADE,null=True, blank=True)
    #course= models.ForeignKey(Course, on_delete=models.CASCADE, related_name='students')

    def __str__(self):
        return self.name