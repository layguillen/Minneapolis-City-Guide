<template>
  <div>
      <div id="review-container" v-for="review in this.$store.state.reviews" v-bind:key="review.id">
          <h3>{{review.title}}</h3>
          <!-- <h4>{{review.user}}</h4> -->
          <p>{{review.isLiked}}</p>
          <p>{{review.description}}</p>
      </div>
  </div>
</template>

<script>
import ReviewService from '../services/ReviewService';

export default {
    name: "reviews",
    
    methods: {
        retrieveReviews(){
            ReviewService.listReviews(this.$route.params.landmarkId)
            .then(response => {
              this.$store.commit("SET_REVIEWS", response.data.reviews);  
            })
            .catch(error => {
                if (error.response && error.response.status === 404) {
                    alert(
                        "Reviews not available. This landmark may have been deleted or you have entered an invalid landmark ID."
                    );
                    this.$router.push({ name: 'Home' });
          }
            });
        },
    },
    created() {
        this.retrieveReviews();
    }
}
</script>

<style>

</style>