<template>
  <div id="landmark-list">
    <fieldset>
      <input
        id="filter-list"
        type="text"
        placeholder="Search landmark by name"
        v-model="search"
      />
    </fieldset>
    <fieldset>
      <select class="type-filter" id="type-filter" v-model="type">
        <option value="">--- Search by type ---</option>
        <option value="Amusement">Amusement</option>
        <option value="Art">Art</option>
        <option value="Educational">Educational</option>
        <option value="Historic">Historic</option>
        <option value="Outdoor">Outdoor</option>
        <option value="Restaurant">Restaurant</option>
        <option value="Shopping">Shopping</option>
        <option value="Venue">Venue</option>
      </select>
    </fieldset>
    <div id="container" v-for="landmark in filteredList" v-bind:key="landmark.id" >
      <div id="landmark-container">
        <h3>{{ landmark.name }}</h3>
        <div id= "img-container">
            <img src="" alt="landmark picture" />
        </div>
        <p>{{ landmark.description }}</p>
      </div>
    </div>
  </div>
</template>

<script>
import landmarkService from "../services/LandmarkService";

export default {
  name: "landmarks",
  data() {
    return {
      search: "",
      type: ""
    };
  },
  created() {
    this.retrieveLandmarks();
  },
  methods: {
    retrieveLandmarks() {
      landmarkService.list().then((response) => {
        this.$store.commit("SET_LANDMARKS", response.data);
      });
    },
    
  },
  computed: {
      filterByType(){
          const filteredLandmarks = this.$store.state.landmarks;

          return filteredLandmarks.filter((landmark)=> {
              if(!landmark.type.indexOf(this.type)){
                  return true;
              }
              return false;
          })
      },
      filteredList() {
      const filteredLandmarks = this.$store.state.landmarks;

      if (this.search != "") {
        return filteredLandmarks.filter((landmark) => {
          if (
              landmark.name
              .toLowerCase()
              .includes(this.search.toLowerCase())
              ) {
                    return true;
                }
          return false;
        });
      }
      return this.filterByType;
    },
  },
};
</script>

<style>

#container {
    display: flex;
    
}

#landmark-container{
    margin: 10px 10px;
    padding: 2%;
    border: 2px #129D8D solid;    

    border-radius: 42px;
    box-shadow:  21px 21px 42px #bebebe,
             -21px -21px 42px #ffffff;

}


</style>