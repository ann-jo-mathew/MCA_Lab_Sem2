from django import forms
from django.contrib.auth.models import User
from django.contrib.auth.forms import AuthenticationForm, UserCreationForm

class RegisterForm(forms.ModelForm):
    password = forms.CharField(widget=forms.PasswordInput)
    password2 = forms.CharField(label='Confirm Password', widget=forms.PasswordInput)
    
    class Meta:
        model=User
        fields=['username','email']

    def clean(self):
        cleaned=super().clean()
        p1=cleaned.get('password')
        p2=cleaned.get('password2')
        
        if p1!=p2:
            raise forms.ValidationError("Passwords do not match.")
        return cleaned
    