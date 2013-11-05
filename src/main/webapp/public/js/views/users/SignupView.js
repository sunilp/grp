define([
  'jquery',
  'underscore',
  'backbone',
  'Session',
  'text!templates/users/signupTemplate.html',
], function($, _, Backbone,Session,signupTemplate){

 var SignupModel = Backbone.Model.extend({
 'message':'',
 'url':'/user'
 });
 
  var SignupView = Backbone.View.extend({
    el: $("#mainContent"),
    //model : {'message': ''},
    
    initialize: function(){
    this.model = new SignupModel();
    this.template = _.template(signupTemplate);
    //_.bindAll(this,this.render);
   // this.model.bind('change', _.bind(this.render, this),this);
    
    },
    
    render: function(){
      console.log('333');
      console.log(this.model);
      this.$el.addClass('container');
      var compiledTemplate =  this.template(this.model );
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
 	   
 	   console.log('email',this.$el.find('#email').val());
 	 //  this.model.save($(ev.currentTarget).serialize());
 	   
 	   
     
       $.post('/user',formDetails, function(data){
         console.log("success from server");
       //	 Backbone.View.goTo('studentRegistration');
       	 
       	Session.login({
			email : that.$el.find('#email').val(),
			password : that.$el.find('#password').val()
		});

       	 
        }).error(function(response){
                 console.log(that.model);
                 that.model.set('message', response.responseText);

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