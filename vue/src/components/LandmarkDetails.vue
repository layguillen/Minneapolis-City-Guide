<template>
  <div class="mainDiv">
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Montserrat Alternates"
    />

    <div id="img-title-details">
      <div class="imgDiv">
        <img
          v-bind:src="this.$store.state.currentLandmark.img_URL"
          id="imgId"
        />
      </div>
      <div id="title-desc">
        <div class="titleDiv">
          <h1 id="landmarkTitle">
            {{ this.$store.state.currentLandmark.name }}
          </h1>
        </div>

        <div class="descDiv">
          <p id="description">
            {{ this.$store.state.currentLandmark.description }}
          </p>
        </div>
      </div>
    </div>

    <div id="button-container">
      <button class="buttons" v-on:click="addToItinerary()">
        add to itinerary
      </button>

      <div class="cancelDiv">
        <button class="buttons">
          <router-link id="homeLink" :to="{ name: 'home' }"
            >view landmarks</router-link
          >
        </button>
      </div>

      <div class="reviewDiv">
        <button class="buttons">
          <router-link id="reviewLink" :to="{ name: 'NewReview' }"
            >leave a review</router-link
          >
        </button>
      </div>

      <div class="likeDiv">
        <button class="buttons">
          likes: {{ this.$store.state.currentLandmark.likes }}
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import landmarkservice from "../services/LandmarkService.js";
export default {
  name: "landmark-details",
  methods: {
    setDetails() {
      landmarkservice.getDetails(this.$route.params.id).then((response) => {
        this.$store.commit("SET_LANDMARK", response.data);
      });
    },
    addToItinerary() {
      this.$store.commit(
        "SET_ITINERARY_LANDMARK",
        this.$store.state.currentLandmark
      );
      alert("Landmark added to Intinerary");
    },
  },
  created() {
    this.setDetails();
  },
};
</script>

<style>
body {
  margin: 0;
  padding: 0;
}
.mainDiv {
  background-color: #004e64;

  /* display: grid;
  grid-template-columns: repeat(2, 1fr);
  grid-template-rows: repeat(3, 1fr);
  grid-template-areas:
    "img desc"
    " . . "
    "footer footer";

  height: 100vh;
  width: 100vw; */

  display: flex;
  flex-direction: column;
  
}

#img-title-details {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  padding: 20px;
  gap: 2rem;
  align-items: center;
  justify-content: center;
}

#title-desc{
  width: 700px;
}

.imgDiv{
   height: 500px;
  width: 600px;
}

#imgId {
  /* grid-area: img; */
  height: 100%;
  width: 100%;
  /* margin-left: 8vh;
  margin-top: 8vh; */
  border-radius: 20%;
}




#button-container {
  grid-area: footer;
  display: flex;
  justify-content: space-evenly;
}

#homeLink {
  text-decoration-line: none;
  color: #f3fced;
}
#reviewLink {
  text-decoration-line: none;
  color: #f3fced;
}

.descDiv {
  /* grid-area: desc; */
  font-family: "Montserrat Alternates", "Franklin Gothic Medium", "Arial Narrow",
    "Arial";
  font-size: 25px;
  color: #f3fced;
  /* margin-top: 20%;
  margin-left: 0%;
  margin-right: 10%; */
  display: flex;
  flex-direction: column;
}

.titleDiv {
  /* grid-area: desc; */
  display: inline-block;
  font-family: "Montserrat Alternates", "Franklin Gothic Medium", "Arial Narrow",
    "Arial";
  font-size: 180%;
  text-decoration-line: underline;
  text-decoration-color: #f3fced;
  text-underline-offset: 20px;
  text-align: left;
  /* margin-top: 7%; */
  /* margin-right: 10px; */
}
#landmarkTitle {
  color: #f3fced;
}
.buttons {
  background-color: #bd92dd;
  color: #f3fced;
  height: 60px;
  width: 250px;
  border-radius: 20px;
  text-decoration-line: none;
  font-size: 25px;
  border: none;
  font-family: "Montserrat Alternates", "Franklin Gothic Medium", "Arial Narrow",
    "Arial";
}
</style>