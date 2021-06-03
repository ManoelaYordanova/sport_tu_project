<template>
  <div class="signUp">
    <b-jumbotron
      class="saveTeacher">
      <b-container>
        <h1 style="margin-bottom: 30px">
          {{message}}
        </h1>
        <b-form-input
          v-model="form.firstName"
          placeholder="Въведи име">
        </b-form-input>
        <b-form-input
          v-model="form.lastName"
          placeholder="Въведи фамилия"
          style="margin-top: 30px">
        </b-form-input>
        <b-form-input
          v-model="form.email"
          placeholder="Въведи имейл"
          style="margin-top: 30px">
        </b-form-input>
        <b-form-textarea
          v-model="form.characteristic"
          placeholder="Въведи описание"
          rows="3"
          max-rows="6"
          style="margin-top: 30px">
        </b-form-textarea>
        <b-button
          style="margin-top: 30px"
          variant="info"
          v-on:click="saveTeacher">
          Въведи
        </b-button>
      </b-container>
    </b-jumbotron>
  </div>
</template>

<script>
import TeacherServices from '../services/teachers-service.js'
export default {
  name: 'SignUp',
  components: {
  },
  data () {
    return {
      message: 'Въвеждане:',
      form: {
        id: '',
        firstName: '',
        lastName: '',
        email: '',
        characteristic: ''
      }
    }
  },
  methods: {
    saveTeacher () {
      TeacherServices.saveTeacher(this.form).then(
        response => {
          this.message = response.data.message
        }
      )
    }
  }
}
</script>
<style scoped>
.signUp {
  min-height: 100vh;
  padding-top: 150px;
  color: darkcyan;
  font-weight: bolder;
  font-style: italic;
  padding-left: 400px;
  padding-right: 400px;
  background-image: url("../assets/m2.jpg");
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
.saveTeacher {
  padding-top: 30px;
  background-color: ghostwhite;
}
</style>
