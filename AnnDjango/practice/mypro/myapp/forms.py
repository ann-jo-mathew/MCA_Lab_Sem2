from django import forms
from .models import Student

class login_form(forms.Form):
    username=forms.CharField()
    password=forms.CharField(widget=forms.PasswordInput)

class StudentForm(forms.ModelForm):
    class Meta:
        model=Student
        fields=['name','age','course','email']