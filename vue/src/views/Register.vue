<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal" id="createaccount">sign up</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
     <div class = "inputFields"> 
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      /> 
      </div>
      <div class = "haveAccount">
      <router-link :to="{ name: 'login' }">Have an account?</router-link>
      </div>
      <button class="btn btn-lg btn-primary btn-block createButton" type="submit">
        create account
      </button>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style>
div#register.text-center{
  display: grid;
  grid-template-columns: repeat(11, .6fr);
  grid-template-rows: repeat(5, .6fr);

}
.text-center{
  height: 80vh;
}
#createaccount{
  text-align: center;
  color: #004E64;
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', 'Arial', 'sans-serif';
  
  

}
button.createButton{
  height: 5vh;
  border-radius: 60px;
  margin-left: 50px;
  margin-right: 50px;
  margin-top: 80px;

  background-color: #004E64;
  color: #F3FCED;

  font-family: 'Franklin Gothic Medium', 'Arial Narrow', 'Arial', 'sans-serif';
  font-size: 30px;

  
}

.form-register{
 display: flex;
 flex-direction: column;

 grid-column-start:5;
 grid-column-end: 8;
 grid-row-start: 2;
 grid-row-end: 5;
 
 border: 5px #004E64 solid;
 border-radius: 20%;
 background: rgb(246, 242, 242);
}

.form-control{ 
  width: 70%;
  margin-left: 15%;
  margin-right: 15%;
  margin-bottom: 10px ;
}

.inputFields {
  margin-top: 50px;
}

.haveAccount{
  margin-left: 15%;
}

</style>
