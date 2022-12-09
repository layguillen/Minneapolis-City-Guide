<template>

  <section id="new-review-container">
<link rel="stylesheet" href='https://fonts.googleapis.com/css?family=Montserrat Alternates'>
      <form v-on:submit.prevent= "saveReview" class="form">
          <h1>Leave a Review</h1>

        <div class="form-element">
            <label for="reviewer">Username:</label>
            <input id="reviewer" type="text" v-model="newReview.username" />
        </div>

        <div class="form-element">
            <label for="title">Title:</label>
            <input id="title" type="text" v-model="newReview.title" />
        </div>

        <div class="form-element">
            <label for="rating">Rating:</label>
            <select id="rating" v-model="newReview.rating">
                <option value="">--- Select Rating ---</option>
                <option value="true">Liked</option>
                <option value="false">Disliked</option>
            </select>
        </div>

        <div class="form-element">
            <label for="review">Review</label>
            <textarea id="review" v-model="newReview.review"></textarea>
        </div>

        <div class="actions">
            <button>Submit</button>
            <button v-on:click= "resetForm" type="button">Cancel</button>
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
        reviewID: {
            type: Number,
            default: 0
        }
    },
    data(){
        return {
            newReview: {
                landmarkID: 0,
                username: '',
                title: '',
                description: '',
                liked: false
            }
        }
    },
    methods: {
        saveReview(){
            const reviewToAdd = {
                landmarkID: Number(this.$route.params.id),
                username: this.newReview.username,
                title: this.newReview.title,
                description: this.newReview.description,
                liked: this.newReview.liked
            };
            //if it's a zero we know it's an insert
            if(this.reviewID === 0){
                //add
                ReviewService.addReview(reviewToAdd)
                .then(response => {
                    //expect a 201 meaning created
                    if(response.status === 201){
                        this.$router.push(`/details/${this.newReview.landmarkID}`)
                    }
                })
                .catch(error => {
                    this.handleErrorResponse(error, "adding")
                })
            }

            //resets form 
            this.newReview = {
                username: '',
                title: '',
                description: '',
                liked: false
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
</style>