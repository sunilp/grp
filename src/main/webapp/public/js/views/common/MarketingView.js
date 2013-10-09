define([
  'jquery',
  'underscore',
  'backbone',
  'text!templates/common/marketingTemplate.html',
   'text!templates/common/featuresTemplate.html',
], function($, _, Backbone,marketingTemplate,featuresTemplate){

  var FeaturesView = Backbone.View.extend({
    el: $("#mainContent"),
    render: function(){
      this.$el.removeClass('container');
      var data ={'features' : featuresTemplate };
      var compiledTemplate =  _.template( marketingTemplate, data );
      this.$el.html(compiledTemplate);
      
  //   var featuresView = new FeaturesView();
  //    featuresView.render();
    }
  });

  return FeaturesView;
});