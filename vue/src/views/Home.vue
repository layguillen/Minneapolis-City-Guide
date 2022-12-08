<template>
  <div class="home">
    <HomeHeader></HomeHeader>
    <div id="filter" class="home-element">
      <h2 id="filter-names">Example</h2>
    </div>
    <div id="main" class="home-element">
      <landmarks />
      
      <!-- <div id="landmarkLister" v-for="landmark in this.$store.landmarks" v-bind:key="landmark.id">
        <img src="../assets/Landmark1.png" alt="Landmark Photo" id="landmarkImg">
        <h3 id="example">{{ landmark.name }}</h3>
      </div> -->
    </div>
  </div>
</template>

<script>
  import HomeHeader from "../components/HomeHeader.vue";
  // import landmarkService from "../services/LandmarkService.js";
  import Landmarks from '../components/Landmarks.vue'

  export default {
    name: "home",
    components: {
      HomeHeader,
      Landmarks
  },
  methods: {
    // setLandmarks() {
    //   landmarkService.listLandmarks().then(response => {
    //     if (response.status == 200) {
    //       this.$store.commit('SET_LANDMARKS', response.data);
    //     } else {
    //       console.log('Something went wrong.');
    //     }
    //   })
    // }
  },

  // created() {
  //   this.setLandmarks();
  // }
};
</script>

<style>

body {
  height: 100vh;
  width: 100vw;
  margin: 0;
}

div.home {
  display: grid;
  grid-template-areas: 
  "header"
  "filter"
  "main";
  grid-template-rows: .1fr .1fr 1fr;
  height: 100vh;
  width: 100vw;
  margin: 0;
  font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial', 'sans-serif';
}

#filter {
  grid-area: filter;
  border-top: #1fd6c1 5px solid;
}

#main {
  grid-area: main;
}

.home-element {
  padding-right: 5%;
  padding-left: 5%;
}

#landmarkLister {
  display: flex;
  flex-direction: row;
  margin: 1.4em;
}

#landmarkImg {
  height: 10em;
}

</style>