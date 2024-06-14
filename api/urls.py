from django.urls import path
from .views import CountryAPIView, StateAPIView, CityAPIView, PlaceAPIView, FoodPlaceAPIView, ThingAPIView

urlpatterns = [
    path('countries/', CountryAPIView.as_view(), name='country-list'),
    path('countries/<int:pk>/', CountryAPIView.as_view(), name='country-detail'),
    path('states/', StateAPIView.as_view(), name='state-list'),
    path('states/<int:pk>/', StateAPIView.as_view(), name='state-detail'),
    path('cities/', CityAPIView.as_view(), name='city-list'),
    path('cities/<int:pk>/', CityAPIView.as_view(), name='city-detail'),
    path('places/', PlaceAPIView.as_view(), name='place-list'),
    path('places/<int:pk>/', PlaceAPIView.as_view(), name='place-detail'),
    path('foodplaces/', FoodPlaceAPIView.as_view(), name='foodplace-list'),
    path('foodplaces/<int:pk>/', FoodPlaceAPIView.as_view(), name='foodplace-detail'),
    path('things/', ThingAPIView.as_view(), name='thing-list'),
    path('things/<int:pk>/', ThingAPIView.as_view(), name='thing-detail'),
]
