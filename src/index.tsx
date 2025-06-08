import IntentExtras from './NativeIntentExtras';

export function multiply(a: number, b: number): number {
  return IntentExtras.multiply(a, b);
}

export function getIntentExtras(): { [key: string]: string } {
  return IntentExtras.getIntentExtras();
}

export function getIntentData(): {
  action: string;
  data: string | null;
  type: string | null;
  categories: string[];
  extras: { [key: string]: string };
} {
  return IntentExtras.getIntentData();
}
