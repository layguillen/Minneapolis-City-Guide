<template>

  <section id="new-review-container">
<link rel="stylesheet" href='https://fonts.googleapis.com/css?family=Montserrat Alternates'>
      <form v-on:submit.prevent= "saveReview" class="form">
          <h1>Leave a Review</h1>
        <!-- <div class="form-element">
            <label for="username">Username:</label>
            <input id="username" type="text" />
        </div> -->

        <div class="form-element">
            <label for="title">Title:</label>
            <input id="title" type="text" v-model="newReview.title" />
        </div>

        <div class="form-element">
            <label for="rating">Rating:</label>
            <select id="rating" v-model="newReview.liked">
                <option value="">--- Select Rating ---</option>
                <option value="true">Liked</option>
                <option value="false">Disliked</option>
            </select>
        </div>

        <div class="form-element">
            <label for="review">Review</label>
            <textarea id="review" v-model="newReview.description"></textarea>
        </div>

        <div class="actions">
            <button id="submit-btn" type="submit">Submit</button>
            <button id="cancel-btn" v-on:click= "resetForm" type="button">Cancel</button>
        </div>

      </form>

  </section>
</template>

<script>
import ReviewService from '../services/ReviewService';

export default {
    name: "review-form",
    components: {
        //N/A
    },
    props: {
        id: {
            type: Number,
            default: 0
        }
    },
    data(){
        return {
            newReview: {
                landmarkID: this.$route.params.id,
                userId: this.$store.state.user.id,
                username: this.$store.state.user.username,
                title: '',
                liked: '',
                description: ''
            }
        }
    },
    methods: {
        saveReview(){
            const reviewToAdd = {
                landmarkID: this.$route.params.id,
                userId: this.$store.state.user.id,
                username: this.$store.state.user.username,
                title: this.newReview.title,
                liked: this.newReview.liked,
                description: this.newReview.description
                
            };
            //if it's a zero we know it's an insert
            if(this.id === 0){
                //add
                ReviewService.addReview(reviewToAdd)
                .then(response => {
                    //expect a 201 meaning created
                    if(response.status === 201){
                        this.$router.push(`/details/${this.reviewToAdd.landmarkID}`)
                    }
                })
                .catch(error => {
                    this.handleErrorResponse(error, "adding");
                    alert("Review was not added.");
                })
            }

            //resets form 
            this.newReview = {
                username: '',
                title: '',
                description: '',
                liked: ''
            }
        }, 
        resetForm(){
            this.newReview = {};
        },
        handleErrorResponse(error, verb) {
            if (error.response) {
                this.errorMsg =
                "Error " + verb + " review. Response received was '" +
                error.response.statusText +
                "'.";
            } else if (error.request) {
                this.errorMsg =
                "Error " + verb + " review. Server could not be reached.";
            } else {
                this.errorMsg =
                "Error " + verb + " review. Request could not be created.";
            }
        }
    }

}
</script>

<style>
.form{
    display: flex;
    flex-direction: column;
    width: 500px;
    margin: 20px;
}
#new-review-container {
    border-top: #1fd6c1 5px solid;
    font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial', 'sans-serif';
    color: #004E64;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;

    
}
h1{
    text-align: center;
}
.form-element{
    margin-top: 10px;
    text-align: center;
    font-weight: bold; 
}

label{
    margin-right: 10px;
}

#username{
    color:#004E64;
    border-radius:7px;
    border-color: #004E64;
}
#title{ 
    border-radius:7px;
    color:#004E64;
    border-color: #004E64;
}
#review{
    border-radius: 7px;
    border-color: #004E64;
    color:#004E64;
}
#rating{
    border-radius: 7px;
    border-color: #004E64;
    color:#004E64;
}

#submit-btn{
  border: 5px solid;
  padding: 8px;
  background-color: #004E64;
  color: #F3FCED;
  border-radius: 12px;
  font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial';
}

#submit-btn:hover{
    cursor: pointer;
}

#cancel-btn{
border: 5px solid;
  padding: 8px;
  background-color: #004E64;
  color: #F3FCED;
  border-radius: 12px;
  font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial';
}

#cancel-btn:hover{
    cursor: pointer;
}

</style>