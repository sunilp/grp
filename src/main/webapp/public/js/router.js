// Filename: router.js
define([
  'jquery',
  'underscore',
  'backbone',
  'views/postings/PostingsView'
], function($, _, Backbone, PostingsView) {
  
  var AppRouter = Backbone.Router.extend({
    routes: {
      // Define some URL routes
      'postings': 'showPostings',
    //  'users': 'showUsers',
      
      // Default
      '*actions': 'defaultAction'
    }
  });
  
  var initialize = function(){

    var app_router = new AppRouter;
    
    app_router.on('route:showPostings', function(){
   
        // Call render on the module we loaded in via the dependency array
        var postingsView = new PostingsView();
        postingsView.render();
        console.log('inpostings');

    });

   // app_router.on('route:showUsers', function () {
    
        // Like above, call render but know that this view has nested sub views which 
        // handle loading and displaying data from the server 
  //      var usersView = new UsersView();
  //  });

    app_router.on('route:defaultAction', function (actions) {
     
       // We have no matching route, lets display the home page 
     //   var homeView = new HomeView();
       // homeView.render();
    	

    });

   

    Backbone.history.start();
  };
  return { 
    initialize: initialize
  };
});