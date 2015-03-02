package com.wordpress.smdaudhilbe.activitytransitiondemo;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ShadowTransition extends Transition {

	private static final String PROPERTY_TRANSLATION_Z = "shadow:translationZ";
	private static final String[] PROPERTIES = { PROPERTY_TRANSLATION_Z };

	public ShadowTransition() {

	}

	public ShadowTransition(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public String[] getTransitionProperties() {
		return PROPERTIES;
	}

	// capture values
	public void captureValues(TransitionValues tValues) {
		float zIs = tValues.view.getTranslationZ();
		tValues.values.put(PROPERTY_TRANSLATION_Z, zIs);
	}

	@Override
	public void captureStartValues(TransitionValues transitionValues) {
		captureValues(transitionValues);
	}

	@Override
	public void captureEndValues(TransitionValues transitionValues) {
		captureValues(transitionValues);
	}

	@Override
	public Animator createAnimator(ViewGroup sceneRoot,TransitionValues startValues, TransitionValues endValues) {

		if (startValues == null || endValues == null
				|| !startValues.values.containsKey(PROPERTY_TRANSLATION_Z)
				|| !endValues.values.containsKey(PROPERTY_TRANSLATION_Z)) {
			return null;
		}

		Float startZ = (Float) startValues.values.get(PROPERTY_TRANSLATION_Z);
		Float endZ = (Float) endValues.values.get(PROPERTY_TRANSLATION_Z);

		View view = endValues.view;
		view.setTranslationZ(startZ);

		return ObjectAnimator.ofFloat(view, View.TRANSLATION_Z, startZ, endZ);
	}
}