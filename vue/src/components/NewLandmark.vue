<template>
  <section id="main">
      <h2 id="page-title">Submit a New Landmark for Consideration</h2>

      <form class="form" v-on:submit.prevent= "saveLandmark">
          <div class="form-group">
            <label for="name">Landmark Name</label>
            <input class="form-control" id="name" type= "text" placeholder="Enter Landmark Name" v-model="newLandmark.name">
          </div>
          <div class="form-group">
            <select class="form-control" id="type" v-model= "newLandmark.type">
                <option value="">--- Select a type ---</option>
                <option value="Amusement">Amusement</option>
                <option value="Art">Art</option>
                <option value="Educational">Educational</option>
                <option value="Historic">Historic</option>
                <option value="Outdoor">Outdoor</option>
                <option value="Restaurant">Restaurant</option>
                <option value="Shopping">Shopping</option>
                <option value="Venue">Venue</option>
            </select>
          </div>
          <div class="form-group">
            <label for="description">Landmark Description</label>
            <textarea class="form-control" id="description" rows="3" v-model= "newLandmark.description"></textarea>
          </div>    
          <div class="form-group">
              <label for="imgURL">Image URL</label>
              <input class="form-control" id="imgURL" type= "url" placeholder="Landmark Image URL" v-model= "newLandmark.imgUrl">
          </div>
          
          <label for="address">Landmark Address:</label>
          <div id="address" class="form-group">
              <label for="street">Street</label>
              <input id="street" type="text" placeholder="street" v-model= "newLandmark.street">
              <label for="city">City</label>
              <input type="text" id="city" placeholder="city" v-model= "newLandmark.city">
              <label for="state">State Abbreviation (ex: MN)</label>
              <input type="text" id="state" placeholder="state abbreviation" v-model= "newLandmark.state">
              <label for="zip">Zip Code</label>
              <input type="number" id="zip" placeholder="zip code" v-model= "newLandmark.zip">
          </div>
          
          <div>
            <button id="btnAddLandmark" type="submit">Add Landmark</button>
          </div>
      </form>
  </section>
</template>

<script>
export default {
    data(){
        return {
            newLandmark: {
                name: '',
                type: '',
                description: '',
                imgUrl: '',
                street: '',
                city: '',
                state: '',
                zip: '',
                approved: false
            }
        }
    },
    methods: {
        saveTodo(){
            this.newLandmark.approved = false;
            // make a pending landmark array in store
            this.$store.commit('', this.newLandmark);
            // resets the form to blank
            this.newLandmark = {
                name: '',
                type: '',
                description: '',
                imgUrl: '',
                address: '',
                approved: false
            }
        }
    }
}
</script>

<style>

body{
  background-color: #F3FCED;
}

#main {
    margin: 1rem 0;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
}

</style>