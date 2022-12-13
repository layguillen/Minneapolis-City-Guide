<template>
  <div id="itinerary-page">
      <HomeHeader id="homeHeader" />
      <itinerary-landmarks-lister />
      <SavedItineraries />
  </div>
</template>

<script>
import HomeHeader from '../components/HomeHeader.vue'
import ItineraryLandmarksLister from '../components/ItineraryLandmarksLister.vue'
import SavedItineraries from '../components/SavedItineraries.vue'


export default {
    name: 'itinerary',
    components: {
        HomeHeader,
        ItineraryLandmarksLister,
        SavedItineraries
    }
}
</script>

<style>

    #homeHeader {
        border-bottom: #1fd6c1 5px solid;
    }
</style>