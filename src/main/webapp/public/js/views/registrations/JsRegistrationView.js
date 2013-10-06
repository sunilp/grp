define([
  'jquery',
  'underscore',
  'backbone',
  'models/registration/JsRegistrationModel',
  'libs/fileupload/jquery.form.min',
  'text!templates/registrations/jsRegistrationTemplate.html',
], function($, _, Backbone, JsRegistrationModel, FileUpload,registrationTemplate){

  var JsRegistrationView = Backbone.View.extend({
    el: $("#mainContent"),
    render: function(){
    
   //    $("#marketingContent").hide();
      this.$el.html(registrationTemplate);
       $("#mainContent").focus()

    },
    events:{
  'submit .jsRegistrationForm':'registerJS',
  'click.cancel': 'cancelRegistration'
 	},
 	registerJS : function(ev){
 	  ev.preventDefault();
 	    console.log("in student registration task");
 	 // var formDetails =  $(ev.currentTarget).serializeObject();
 	  var formDetails =  $(ev.currentTarget).serializeArray();
        console.log(formDetails);
 	 var jsRegistrationModel = new JsRegistrationModel();
 
   //  jsRegistrationModel.save(formDetails,{
 //		success: function(task){
//      console.log("sucess from server");
 //			router.navigate('',{trigger:true});
 //		}
 //	});
     
    $.post('/reg',formDetails, function(data){
      console.log("sucess from server");
    
    }); 
  
  var options = { 
    url:        '/reg/upload', 
    type: 'POST',
      success:    function() { 
      console.log("sucess from server");    } 
  }; 
  
 //$('.jsRegistrationForm').ajaxForm(options);

console.log('doneee');
 
  return false;
 	
 	},
 	
 	cancelRegistration :function(ev){
 	 
 	 Backbone.View.goTo('');
 	
 	}
 	
 	
  });

  return JsRegistrationView;
});