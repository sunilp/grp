define([
  'jquery',
  'underscore',
  'backbone',
  'models/posting/PostingModel',
  'collections/postings/PostingsCollection',
  'views/postings/PostingsListView',
  'text!templates/postings/postingsTemplate.html'
], function($, _, Backbone, PostingModel, PostingsCollection, PostingsListView, postingsTemplate){

  var PostingsView = Backbone.View.extend({
    el: $("#sampleCont"),
    render: function(){
     // $('.menu li').removeClass('active');
      //$('.menu li a[href="'+window.location.hash+'"]').parent().addClass('active');
      this.$el.html(postingsTemplate);

      var posting0 = new PostingModel({type: 'job', company: 'Cognizant', qualification : 'CS'}); 
      var posting1 = new PostingModel({type: 'job', company: 'Cognizant', qualification : 'CS'}); 
      var posting2 = new PostingModel({type: 'job', company: 'eee', qualification : 'CS'}); 
      var posting3 = new PostingModel({type: 'job', company: 'Cognizant', qualification : 'CS'}); 
      var posting4 = new PostingModel({type: 'job', company: 'Cognizant', qualification : 'CS'}); 
      
      var aPostings = [posting0, 
                       posting1,
                       posting2,
                       posting3,
                       posting4];

      var postingsCollection = new PostingsCollection(aPostings);  
      var postingsListView = new PostingsListView({ collection: postingsCollection}); 
      
      postingsListView.render(); 

      // add the sidebar 
      //var sidebarView = new SidebarView();
      //sidebarView.render();

    }
  });

  return PostingsView;
});