define([
  'jquery',
  'underscore',
  'backbone',
  'text!templates/common/featuresTemplate.html'
], function($, _, Backbone, featuresTemplate){

  var FeaturesView = Backbone.View.extend({
    el: $("#innerContent"),
    render: function(){
    console.log( this.$el);
      this.$el.html(featuresTemplate);
      console.log(2);
    }
  });

  return FeaturesView;
});