from django.contrib.auth.models import User
from django.core.management.base import BaseCommand


class Command(BaseCommand):
    help = 'Create two test users securely using create_user'

    def handle(self, *args, **kwargs):
        users = [
            ('user1', 'User@12345'),
            ('user2', 'User@12345'),
        ]

        for username, password in users:
            if not User.objects.filter(username=username).exists():
                User.objects.create_user(username=username, password=password)

        self.stdout.write(self.style.SUCCESS('Test users created/verified.'))
