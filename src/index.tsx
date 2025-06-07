import IntentExtras from './NativeIntentExtras';

export function multiply(a: number, b: number): number {
  return IntentExtras.multiply(a, b);
}

export function getIntentExtras(): { [key: string]: string } {
  return IntentExtras.getIntentExtras();
}
