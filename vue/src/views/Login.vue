<template>
  <div id="login" class="text-center">
    <form id="form-signin" class="form-signin" @submit.prevent="login">
      <div
        class="alert alert-danger form-element"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success form-element"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <input
        type="text"
        id="username"
        class="form-control form-element"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <input
        type="password"
        id="password"
        class="form-control form-element"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <button class="form-element" type="submit">Sign in</button>
      <router-link id="register" class="form-element" :to="{ name: 'register' }">Need an account?</router-link>
    </form>
     
    <img class="logo" src="../assets/Glider-1.png">
  
  </div>
 
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>
<style>

body{
  background-color: #F3FCED;
}
div#login.text-center{
  height: 90vh;
  width: 90vw;
  margin: 0;
  display: grid;
  grid-template-areas: 
  "img login";
  grid-template-rows: 1fr 1fr;
}

img{
  grid-area: img;
  height: 90vh;
  justify-self: center;
}

#form-signin{
  grid-area: login;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-self: center;
  border: 1px black solid;
  border-radius: 10%;
  padding: 10%;

  background: white;
}

.form-element {
  margin-top: 1.5rem;
  margin-bottom: 1.5rem;
}

#register {
  text-align: center;
}
</style>
