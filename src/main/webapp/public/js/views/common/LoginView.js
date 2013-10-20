define([
	'jquery',
	'core/BaseView',
	'Session',
	'text!templates/common/loginTemplate.html'
], function($, BaseView, Session,  loginTemplate){

	var LoginView = BaseView.extend({
       // el: $("#mainContent"),
        model : {'status':'', 'statusText': ''},
        
		template : _.template(loginTemplate,{'status':'', 'statusText': ''}),
		
		events : {
			'click button.btn-info' : 'submit'
		},

		render : function(){
		
			
		this.template = _.template(loginTemplate,this.model);
		
		  this.$el.addClass('container');
		
			this.$el.html(this.template);
			return this;
		},

		submit : function(e){
			e.preventDefault();
			var email = $('#email').val();
			var password = $('#password').val();
			var data = Session.login({
				email : email,
				password : password
			});
			
			this.model = data;
			this.render();
		}
	});

	return LoginView;

});