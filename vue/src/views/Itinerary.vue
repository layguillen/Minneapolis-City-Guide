<template>
  <div id="itinerary-page">
      <HomeHeader id="homeHeader" />
  </div>
</template>

<script>
import HomeHeader from '../components/HomeHeader.vue'
export default {
    name: 'itinerary',
    components: {
        HomeHeader
    }
}
</script>

<style>

    #homeHeader {
        border-bottom: #1fd6c1 5px solid;
    }
</style>