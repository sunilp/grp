define([
	'core/BaseView',
	'Session',
	'text!templates/common/profileTemplate.html'
], function(BaseView, Session, profileTemplate){

	var ProfileView = BaseView.extend({

		template : _.template(profileTemplate),

		events : {
			'click .logout' : 'logout'
		},

		render : function(){
		this.$el.addClass('container');
		this.$el.html(this.template(this.model));
		$('#loginlogout').html('<a class="logout">Logout</a>');
		
			return this;
		},

		logout : function(e){
		 $('#loginlogout').html('<a href="#login">Login</a>');
		 
			Session.logout(function(){
				Backbone.history.navigate('', { trigger : true });
			});
		}
	});

	return ProfileView;

});