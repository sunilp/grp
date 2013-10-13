define([
  'jquery',
  'underscore',
  'backbone'
], function($,_,Backbone) {

	var UserModel = Backbone.Model.extend({

		defaults : {
			'firstName' : null,
			'lastName' : null
		},

		getFullName : function(){
			return this.get('firstName') + ' ' + this.get('lastName');
		},

		urlRoot : '/users'
	});

	return UserModel;
});