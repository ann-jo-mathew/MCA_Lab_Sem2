from django.urls import path
from . import views

urlpatterns = [
    path('login/',views.login_view, name='login'),
    path('dashboard/',views.dashboard,name='dashboard'),
    path('logout/',views.logout_view,name='logout'),
    path('list/',views.list_view,name='list'),
    path('edit/<int:id>/',views.edit_view,name='edit'),
    path('delete/<int:id>/',views.delete_view,name='delete'),
    path('create',views.create_view,name='create'),
]