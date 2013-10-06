define([
  'jquery',
  'underscore',
  'backbone'
], function($,_,Backbone) {
  
  var JsRegistrationModel=Backbone.Model.extend({
	  
	  url: '/reg'
  });

  return JsRegistrationModel;

});