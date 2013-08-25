define([
  'jquery',
  'underscore',
  'backbone'
], function($,_,Backbone) {
  
  var PostingModel=Backbone.Model.extend({
	  defaults: {
	      type: "job"
	    }
  });

  return PostingModel;

});