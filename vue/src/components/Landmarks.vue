<template>
  <div id="landmark-body">
    <div id="form-inputs">
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
    </div>
    <div id="landmark-list">
    <div id="container" v-for="landmark in filteredList" v-bind:key="landmark.id" >
      <div id="landmark-container">
        <h3>{{ landmark.name}}</h3>
        <div id= "img-container">
            <img class="display-img" :src="landmark.img_URL" />
        </div>
        <p>{{ landmark.type }}</p>
      </div>
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
      type: "",
      i: 1,
      imgURL: "",
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
    }
  },
};
</script>

<style>

#landmark-list {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
}

#landmark-container{
    margin: 10px 10px;
    padding: 2%;
    border: 2px #129D8D solid;
    background-color: #129D8D;
    color: #F3FCED;
    border-radius: 42px;
    text-align: center;
}

#form-inputs {
  display: flex;
  flex-direction: row;
  justify-content:space-evenly;
}

fieldset {
  width: 15%;
  text-align: center;
}

.display-img {
  height: 7rem;
}

#container {
    height: 20%;
    width: 20%;
}

</style>