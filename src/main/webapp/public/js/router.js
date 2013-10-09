// Filename: router.js
define([
  'jquery',
  'underscore',
  'backbone',
  'Session',
  'core/BaseRouter',
  'views/postings/PostingsView',
  'views/registrations/JsRegistrationView',
  'views/common/FeaturesView',
  'views/common/MarketingView',
  'views/common/LoginView'
], function($, _, Backbone,Session,BaseRouter, PostingsView, JsRegistrationView,FeaturesView
             ,MarketingView,LoginView) {
  
  var AppRouter = BaseRouter.extend({
    routes: {
      // Define some URL routes
      '':'home',
      'home':'home',
      'login':'showLogin',
      'profile':'showProfile',
      'postings': 'showPostings',
    //  'users': 'showUsers',
      'studentRegistration' : 'registerJobSeeker',
      // Default
      '*actions': 'defaultAction'
    },
    requresAuth : ['#profile'],
    	// Routes that should not be accessible if user is authenticated
        // for example, login, register, forgetpasword ...
    preventAccessWhenAuth : ['#login'],
    
    before : function(params, next){
			//Checking if user is authenticated or not
			//then check the path if the path requires authentication 
			var isAuth = Session.get('authenticated');
			var path = Backbone.history.location.hash;
			var needAuth = _.contains(this.requresAuth, path);
			var cancleAccess = _.contains(this.preventAccessWhenAuth, path);

			if(needAuth && !isAuth){
				//If user gets redirect to login because wanted to access
				// to a route that requires login, save the path in session
				// to redirect the user back to path after successful login
				Session.set('redirectFrom', path);
				Backbone.history.navigate('login', { trigger : true });
			}else if(isAuth && cancleAccess){
				//User is authenticated and tries to go to login, register ...
				// so redirect the user to home page
				Backbone.history.navigate('', { trigger : true });
			}else{
				//No problem handle the route
				return next();
			}			
		},

		after : function(){
			//empty
		},

		changeView : function(view){
			//Close is a method in BaseView
			//that check for childViews and 
			//close them before closing the 
			//parentView
			function setView(view){
				if(this.currentView){
					this.currentView.close();
				}
				this.currentView = view;
				$('#mainContent').html(view.render().$el);
			}

			setView(view);
		},

    home: function(){
      var marketingView = new MarketingView();
          marketingView.render();
       
    },
    fetchError : function(error){
			//If during fetching data from server, session expired
			// and server send 401, call getAuth to get the new CSRF
			// and reset the session settings and then redirect the user
			// to login
			if(error.status === 401){
				Session.getAuth(function(){
					Backbone.history.navigate('login', { trigger : true });
				});
			}
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
  
  
      app_router.on('route:registerJobSeeker', function () {
     
       var jsRegistrationView = new JsRegistrationView();
       jsRegistrationView.render();
       console.log('opening student registration');
    	

    });

    app_router.on('route:defaultAction', function (actions) {
     
       // We have no matching route, lets display the home page 
     //   var homeView = new HomeView();
       // homeView.render();
    	

    });

  app_router.on('route:showLogin',  function(){
			var loginView = new LoginView();
			app_router.changeView(loginView);
		});

  app_router.on('route:showProfile' , function(){
			var that = app_router;
			var userModel = new UserModel({
				id : Session.get('user').id
			});
			userModel.fetch()
				.done(function(){
					var profileView = new ProfileView({
						model : userModel
					});
					that.changeView(profileView);
				})
				.fail(function(error){
					//In case that session expired
					that.fetchError(error);
				});
		});
  

   Backbone.View.goTo = function (loc) {
    app_router.navigate(loc, true);
  };
   

    Backbone.history.start();
  };
  return { 
    initialize: initialize
  };
});