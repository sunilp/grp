define([
  'jquery',
  'underscore',
  'backbone',
  'text!templates/common/featuresTemplate.html'
], function($, _, Backbone, featuresTemplate){

  var FeaturesView = Backbone.View.extend({
    el: $("#mainContent"),
    render: function(){
      this.$el.html(featuresTemplate);
    }
  });

  return FeaturesView;
});