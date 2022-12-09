<template>
  <div id="itinerary-page">
      <HomeHeader id="homeHeader" />
      <itinerary-landmarks-lister />
      <Map />
  </div>
</template>

<script>
import HomeHeader from '../components/HomeHeader.vue'
import ItineraryLandmarksLister from '../components/ItineraryLandmarksLister.vue'
import Map from '../components/Map.vue'

export default {
    name: 'itinerary',
    components: {
        HomeHeader,
        ItineraryLandmarksLister,
        Map
    }
}
</script>

<style>

    #homeHeader {
        border-bottom: #1fd6c1 5px solid;
    }
</style>