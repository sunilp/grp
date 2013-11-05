define([
	'jquery',
	'handlebars',
	'core/BaseView',
	'Session',
	'models/user/UserModel',
	'text!templates/common/layout/navbarTemplate.html'
], function($,Handlebars, BaseView, Session, UserModel, navbarTemplate){

	var NavBarView = BaseView.extend({
		initialize : function(){
			Handlebars.registerHelper('ifCond', function(v1, v2, options) {
				  if(v1 === v2) {
				    return options.fn(this);
				  }
				  return options.inverse(this);
				});
		},
        el: $("#header"),
        model : UserModel,
        
		template : Handlebars.compile(navbarTemplate),
		
		events : {
			'click button.btn-info' : 'submit'
		},

		render : function(){
		
			
	//	this.template = _.template(loginTemplate,this.model);
				
			this.$el.html(this.template(this.model));
			return this;
		},

		submit : function(e){
			e.preventDefault();
			console.log('inside submit');
			var email = $('#email').val();
			var password = $('#password').val();
			var data = Session.login({
				email : email,
				password : password
			});
			
			console.log(data);
			//this.model = data;
			//this.render();
		}
	});

	return NavBarView;

});