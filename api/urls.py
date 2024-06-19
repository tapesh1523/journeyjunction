from django.urls import path,include
from rest_framework.routers import DefaultRouter
from .views import CountryViewSet, StateViewSet, CityViewSet, PlaceViewSet, FoodPlaceViewSet, ThingViewSet

router = DefaultRouter()
router.register(r'countries', CountryViewSet, basename='country')
router.register(r'states', StateViewSet, basename='state')
router.register(r'cities', CityViewSet, basename='city')
router.register(r'places', PlaceViewSet, basename='place')
router.register(r'foodplaces', FoodPlaceViewSet, basename='foodplace')
router.register(r'things', ThingViewSet, basename='thing')

urlpatterns = [
    # path('countries/', CountryAPIView.as_view(), name='country-list'),
    # path('countries/<int:pk>/', CountryAPIView.as_view(), name='country-detail'),
    # path('states/', StateAPIView.as_view(), name='state-list'),
    # path('states/<int:pk>/', StateAPIView.as_view(), name='state-detail'),
    # path('cities/', CityAPIView.as_view(), name='city-list'),
    # path('cities/<int:pk>/', CityAPIView.as_view(), name='city-detail'),
    # path('places/', PlaceAPIView.as_view(), name='place-list'),
    # path('places/<int:pk>/', PlaceAPIView.as_view(), name='place-detail'),
    # path('foodplaces/', FoodPlaceAPIView.as_view(), name='foodplace-list'),
    # path('foodplaces/<int:pk>/', FoodPlaceAPIView.as_view(), name='foodplace-detail'),
    # path('things/', ThingAPIView.as_view(), name='thing-list'),
    # path('things/<int:pk>/', ThingAPIView.as_view(), name='thing-detail'),
    path('', include(router.urls)),
]
