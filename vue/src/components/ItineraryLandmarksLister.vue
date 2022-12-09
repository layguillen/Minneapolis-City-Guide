<template>
  <div id="itinerary-container">
      <h1>Your Itinerary</h1>
      <Map />
      <div id="landmarks" v-for="landmark in this.$store.state.itineraryLandmarks" v-bind:key="landmark.id">
          <div id="title-btn-container">
              <h2 id="landmark-name">{{ landmark.name }}</h2>
              <button id="removeBtn" v-on:click="removeFromItinerary(landmark.id)">Remove</button>
          </div>
          <div id="desc-img-container">
            <div id="img-container">
                <img id="landmark-img" :src="landmark.img_URL" alt="Landmark Img">
            </div>  
            <p id="landmark-description"> {{landmark.description}}</p>
          </div>
      </div>
      <div>
          <label for="hotel"></label>
          <select class="hotel" id="hotel" v-model="search">
              <option value="31">--- Select your hotel ---</option>
              <option value="32">The Marquette Hotel</option>
              <option value="33">Hyatt Place Minneapolis/Downtown</option>
              <option value="34">Hewing Hotel</option>
              <option value="35">Hotel Ivy</option>
              <option value="36">The Westin Minneapolis</option>
              <option value="37">Hyatt Regency Minneapolis</option>
              <option value="38">Millennium Minneapolis</option>
              <option value="39">Aloft Minneapolis</option>
              <option value="40">Radisson RED Minneapolis Downtown</option>
              <option value="41">Hilton Minneapolis</option>
              <option value="42">The Royal Sonesta Minneapolis Downtown</option>
              <option value="43">Four Seasons Hotel Minneapolis</option>
              <option value="44">Minneapolis Marriott City Center</option>
              <option value="45">Embassy Suites by Hilton Minneapolis Downtown</option>
              <option value="46">Graduate Minneapolis</option>
              <option value="47">Moxy Minneapolis Uptown</option>
              <option value="48">Rand Tower Hotel, Minneapolis</option>
              <option value="49">Hyatt Centric Downtown Minneapolis</option>
              <option value="50">The Foshay</option>
              <option value="51">Renaissance Minneapolis Hotel</option>
              <option value="52">Hampton Inn & Suites Minneapolis/Downtown</option>
          </select>
      </div>
      <div id="delete-btn-container">
          <button id="deleteBtn" v-on:click="deleted()">Delete Itinerary</button>
      </div>
  </div>
</template>

<script>
import Map from '../components/Map.vue'
import HotelService from '../services/HotelService'

export default {
    name: "itinerary-landmarks-lister",
    components: {
        Map
    },
    data(){
        return {
            search: ""
        }
    },
    created() {
        // this.$store.state.landmarks.forEach(element => {
        //     this.$store.commit('SET_ITINERARY_LANDMARK', element);
        // });
    },
    methods: {
        removeFromItinerary(id){
           this.$store.commit("REMOVE_ITINERARY_LANDMARK", id);
           alert("Landmark removed from itinerary");
        },
        deleted() {
            this.$store.commit('EMPTY_ITINERARY_LANDMARKS');
            alert("Itinerary deleted");
        },
        retrieveHotel(){
            HotelService.listHotels()
            
        }
    }
}
</script>

<style>

#itinerary-container{
    border: 2px #129D8D solid;
    margin: 20px 30px;
    padding: 1%;
    border-radius: 42px;
}

h1{
    text-align: center;
    color: #004E64;
    font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial', 'sans-serif';
}

#landmarks{
    display: flex;  
    flex-direction: column;
    margin: 10px 10px;
    padding: 1%;
}

#title-btn-container{
    display: flex;
    justify-content: space-between;
}

#desc-img-container{
    display: flex;
    justify-content: space-between;
}

#landmark-description{
    font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial';
    color: #004E64;
}

#landmark-img{
    padding: 2px;
    margin-right: 10px;
    height: 10rem;
}

#removeBtn{
    font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial';
    border: 5px solid;
    padding: 8px;
    background-color: #004E64;
    color: #F3FCED;
    border-radius: 12px;
}

#removeBtn:hover {
  cursor: pointer;
}

#delete-btn-container{
    display: flex;
    justify-content: center;
    align-items: center; 
}

#deleteBtn{
    font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial';
    border: 5px solid;
    padding: 8px;
    background-color: #004E64;
    color: #F3FCED;
    border-radius: 12px;
}

#deleteBtn:hover{
    cursor: pointer;
}

</style>