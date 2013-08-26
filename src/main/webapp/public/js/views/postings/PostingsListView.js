// Filename: views/postings/list
define([
  'jquery',
  'underscore',
  'backbone',
  // Pull in the Collection module from above,
  'models/posting/PostingModel',
  'collections/postings/PostingsCollection',
  'text!templates/postings/postingsListTemplate.html'

], function($, _, Backbone, PostingModel, PostingsCollection, postingsListTemplate){
  var PostingsListView = Backbone.View.extend({
    el: $("#postings-list"),

    
    render: function(){
      
      var data = {
        postings: this.collection.models,
        _: _ 
      };

      var compiledTemplate = _.template( postingsListTemplate, data );
      $("#postings-list").html( compiledTemplate ); 
    }
  });
  return PostingsListView;
});