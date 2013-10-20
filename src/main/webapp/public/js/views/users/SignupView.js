define([
  'jquery',
  'underscore',
  'backbone',
  'text!templates/users/signupTemplate.html',
], function($, _, Backbone,signupTemplate){

  var SignupView = Backbone.View.extend({
    el: $("#mainContent"),
    model : {'message': ''},
    
    render: function(){
      
      this.$el.addClass('container');
      var compiledTemplate =  _.template( signupTemplate, this.model );
      this.$el.html(compiledTemplate);
    
    },
    events:{
      'submit .signupForm':'signup',
      'click .cancel': 'cancel'
 	},
 	 signup : function(ev){
 	   ev.preventDefault();
 	   var that = this;
 	  
 	   var formDetails =  $(ev.currentTarget).serializeArray();
     
       $.post('/user',formDetails, function(data){
         console.log("success from server");
       	 Backbone.View.goTo('studentRegistration');
        }).error(function(response){
         that.model.message =  response.responseText;
        that.render();
        }); 
 
       return false;
 	
 	},
 	
 	cancel :function(ev){
 	 
 	 Backbone.View.goTo('');
 	
 	}
 	
 	
  });

  return SignupView;
});