import type { TurboModule } from 'react-native';
import { TurboModuleRegistry } from 'react-native';

export interface Spec extends TurboModule {
  multiply(a: number, b: number): number;
  getIntentExtras(): { [key: string]: string };
  getIntentData(): {
    action: string;
    data: string | null;
    type: string | null;
    categories: string[];
    extras: { [key: string]: string };
  };
}

export default TurboModuleRegistry.getEnforcing<Spec>('IntentExtras');
