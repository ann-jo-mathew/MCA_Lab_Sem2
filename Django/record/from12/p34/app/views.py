from django.shortcuts import render, redirect, get_object_or_404
from django.contrib.auth.decorators import login_required
from django.http import HttpResponseForbidden
from .models import Post

def post_list(request):
    posts = Post.objects.all().order_by('-created_at')
    return render(request, 'app/list.html', {'posts': posts})

def post_detail(request, id):
    post = get_object_or_404(Post, id=id)
    return render(request, 'app/detail.html', {'post': post})

@login_required
def post_create(request):
    if request.method == "POST":
        title = request.POST.get('title')
        content = request.POST.get('content')
        Post.objects.create(title=title, content=content, author=request.user)
        return redirect('post_list')
    return render(request, 'app/form.html')

@login_required
def post_edit(request, id):
    post = get_object_or_404(Post, id=id)
    if not (request.user == post.author or request.user.is_staff):
        return HttpResponseForbidden("You are not allowed to edit this post.")
    
    if request.method == "POST":
        post.title = request.POST.get('title')
        post.content = request.POST.get('content')
        post.save()
        return redirect('post_detail', id=post.id)
    return render(request, 'app/form.html', {'post': post})

@login_required
def post_delete(request, id):
    post = get_object_or_404(Post, id=id)
    if not (request.user == post.author or request.user.is_staff):
        return HttpResponseForbidden("You are not allowed to delete this post.")
    
    if request.method == "POST":
        post.delete()
        return redirect('post_list')
    return render(request, 'app/confirm_delete.html', {'post': post})
